package com.google.tv.material.catalog.colorutils

import androidx.compose.ui.graphics.Color
import androidx.tv.material3.ColorScheme
import androidx.tv.material3.ExperimentalTvMaterial3Api
import kotlin.math.pow


/**
 * Color science utilities.
 *
 *
 * Utility methods for color science constants and color space conversions that aren't HCT or
 * CAM16.
 */
object ColorUtils {
    val SRGB_TO_XYZ = arrayOf(
        doubleArrayOf(0.41233895, 0.35762064, 0.18051042),
        doubleArrayOf(0.2126, 0.7152, 0.0722),
        doubleArrayOf(0.01932141, 0.11916382, 0.95034478)
    )
    val XYZ_TO_SRGB = arrayOf(
        doubleArrayOf(
            3.2413774792388685, -1.5376652402851851, -0.49885366846268053
        ), doubleArrayOf(
            -0.9691452513005321, 1.8758853451067872, 0.04156585616912061
        ), doubleArrayOf(
            0.05562093689691305, -0.20395524564742123, 1.0571799111220335
        )
    )
    val WHITE_POINT_D65 = doubleArrayOf(95.047, 100.0, 108.883)

    /** Converts a color from RGB components to ARGB format.  */
    fun argbFromRgb(red: Int, green: Int, blue: Int): Int {
        return 255 shl 24 or (red and 255 shl 16) or (green and 255 shl 8) or (blue and 255)
    }

    /** Converts a color from linear RGB components to ARGB format.  */
    fun argbFromLinrgb(linrgb: DoubleArray): Int {
        val r = delinearized(linrgb[0])
        val g = delinearized(linrgb[1])
        val b = delinearized(linrgb[2])
        return argbFromRgb(r, g, b)
    }

    /** Returns the alpha component of a color in ARGB format.  */
    fun alphaFromArgb(argb: Int): Int {
        return argb shr 24 and 255
    }

    /** Returns the red component of a color in ARGB format.  */
    fun redFromArgb(argb: Int): Int {
        return argb shr 16 and 255
    }

    /** Returns the green component of a color in ARGB format.  */
    fun greenFromArgb(argb: Int): Int {
        return argb shr 8 and 255
    }

    /** Returns the blue component of a color in ARGB format.  */
    fun blueFromArgb(argb: Int): Int {
        return argb and 255
    }

    /** Returns whether a color in ARGB format is opaque.  */
    fun isOpaque(argb: Int): Boolean {
        return alphaFromArgb(argb) >= 255
    }

    /** Converts a color from ARGB to XYZ.  */
    fun argbFromXyz(x: Double, y: Double, z: Double): Int {
        val matrix = XYZ_TO_SRGB
        val linearR = matrix[0][0] * x + matrix[0][1] * y + matrix[0][2] * z
        val linearG = matrix[1][0] * x + matrix[1][1] * y + matrix[1][2] * z
        val linearB = matrix[2][0] * x + matrix[2][1] * y + matrix[2][2] * z
        val r = delinearized(linearR)
        val g = delinearized(linearG)
        val b = delinearized(linearB)
        return argbFromRgb(r, g, b)
    }

    /** Converts a color from XYZ to ARGB.  */
    fun xyzFromArgb(argb: Int): DoubleArray {
        val r = linearized(redFromArgb(argb))
        val g = linearized(greenFromArgb(argb))
        val b = linearized(blueFromArgb(argb))
        return MathUtils.matrixMultiply(doubleArrayOf(r, g, b), SRGB_TO_XYZ)
    }

    /** Converts a color represented in Lab color space into an ARGB integer.  */
    fun argbFromLab(l: Double, a: Double, b: Double): Int {
        val whitePoint = WHITE_POINT_D65
        val fy = (l + 16.0) / 116.0
        val fx = a / 500.0 + fy
        val fz = fy - b / 200.0
        val xNormalized = labInvf(fx)
        val yNormalized = labInvf(fy)
        val zNormalized = labInvf(fz)
        val x = xNormalized * whitePoint[0]
        val y = yNormalized * whitePoint[1]
        val z = zNormalized * whitePoint[2]
        return argbFromXyz(x, y, z)
    }

    /**
     * Converts a color from ARGB representation to L*a*b* representation.
     *
     * @param argb the ARGB representation of a color
     * @return a Lab object representing the color
     */
    fun labFromArgb(argb: Int): DoubleArray {
        val linearR = linearized(redFromArgb(argb))
        val linearG = linearized(greenFromArgb(argb))
        val linearB = linearized(blueFromArgb(argb))
        val matrix = SRGB_TO_XYZ
        val x = matrix[0][0] * linearR + matrix[0][1] * linearG + matrix[0][2] * linearB
        val y = matrix[1][0] * linearR + matrix[1][1] * linearG + matrix[1][2] * linearB
        val z = matrix[2][0] * linearR + matrix[2][1] * linearG + matrix[2][2] * linearB
        val whitePoint = WHITE_POINT_D65
        val xNormalized = x / whitePoint[0]
        val yNormalized = y / whitePoint[1]
        val zNormalized = z / whitePoint[2]
        val fx = labF(xNormalized)
        val fy = labF(yNormalized)
        val fz = labF(zNormalized)
        val l = 116.0 * fy - 16
        val a = 500.0 * (fx - fy)
        val b = 200.0 * (fy - fz)
        return doubleArrayOf(l, a, b)
    }

    /**
     * Converts an L* value to an ARGB representation.
     *
     * @param lstar L* in L*a*b*
     * @return ARGB representation of grayscale color with lightness matching L*
     */
    fun argbFromLstar(lstar: Double): Int {
        val y = yFromLstar(lstar)
        val component = delinearized(y)
        return argbFromRgb(component, component, component)
    }

    /**
     * Computes the L* value of a color in ARGB representation.
     *
     * @param argb ARGB representation of a color
     * @return L*, from L*a*b*, coordinate of the color
     */
    fun lstarFromArgb(argb: Int): Double {
        val y = xyzFromArgb(argb)[1]
        return 116.0 * labF(y / 100.0) - 16.0
    }

    /**
     * Converts an L* value to a Y value.
     *
     *
     * L* in L*a*b* and Y in XYZ measure the same quantity, luminance.
     *
     *
     * L* measures perceptual luminance, a linear scale. Y in XYZ measures relative luminance, a
     * logarithmic scale.
     *
     * @param lstar L* in L*a*b*
     * @return Y in XYZ
     */
    fun yFromLstar(lstar: Double): Double {
        return 100.0 * labInvf((lstar + 16.0) / 116.0)
    }

    /**
     * Linearizes an RGB component.
     *
     * @param rgbComponent 0 <= rgb_component <= 255, represents R/G/B channel
     * @return 0.0 <= output <= 100.0, color channel converted to linear RGB space
     */
    fun linearized(rgbComponent: Int): Double {
        val normalized = rgbComponent / 255.0
        return if (normalized <= 0.040449936) {
            normalized / 12.92 * 100.0
        } else {
            ((normalized + 0.055) / 1.055).pow(2.4) * 100.0
        }
    }

    /**
     * Delinearizes an RGB component.
     *
     * @param rgbComponent 0.0 <= rgb_component <= 100.0, represents linear R/G/B channel
     * @return 0 <= output <= 255, color channel converted to regular RGB space
     */
    fun delinearized(rgbComponent: Double): Int {
        val normalized = rgbComponent / 100.0
        var delinearized = 0.0
        delinearized = if (normalized <= 0.0031308) {
            normalized * 12.92
        } else {
            1.055 * normalized.pow(1.0 / 2.4) - 0.055
        }
        return MathUtils.clampInt(0, 255, Math.round(delinearized * 255.0).toInt())
    }

    /**
     * Returns the standard white point; white on a sunny day.
     *
     * @return The white point
     */
    fun whitePointD65(): DoubleArray {
        return WHITE_POINT_D65
    }

    fun labF(t: Double): Double {
        val e = 216.0 / 24389.0
        val kappa = 24389.0 / 27.0
        return if (t > e) {
            t.pow(1.0 / 3.0)
        } else {
            (kappa * t + 16) / 116
        }
    }

    fun labInvf(ft: Double): Double {
        val e = 216.0 / 24389.0
        val kappa = 24389.0 / 27.0
        val ft3 = ft * ft * ft
        return if (ft3 > e) {
            ft3
        } else {
            (116 * ft - 16) / kappa
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
fun Scheme.toColorScheme(): ColorScheme {
    return ColorScheme(
        primary = Color(primary),
        onPrimary = Color(onPrimary),
        primaryContainer = Color(primaryContainer),
        onPrimaryContainer = Color(onPrimaryContainer),
        inversePrimary = Color(inversePrimary),
        secondary = Color(secondary),
        onSecondary = Color(onSecondary),
        secondaryContainer = Color(secondaryContainer),
        onSecondaryContainer = Color(onSecondaryContainer),
        tertiary = Color(tertiary),
        onTertiary = Color(onTertiary),
        tertiaryContainer = Color(tertiaryContainer),
        onTertiaryContainer = Color(onTertiaryContainer),
        background = Color(background),
        onBackground = Color(onBackground),
        surface = Color(surface),
        onSurface = Color(onSurface),
        surfaceVariant = Color(surfaceVariant),
        onSurfaceVariant = Color(onSurfaceVariant),
        surfaceTint = Color(primary),
        inverseSurface = Color(inverseSurface),
        inverseOnSurface = Color(inverseOnSurface),
        error = Color(error),
        onError = Color(onError),
        errorContainer = Color(errorContainer),
        onErrorContainer = Color(onErrorContainer),
        border = Color(outline),
        borderVariant = Color(outlineVariant),
        scrim = Color(scrim),
    )
}
