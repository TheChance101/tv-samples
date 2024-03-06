package com.google.jetfit.presentation.screens.subscription.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun SubscriptionOptions(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Our plans",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        SubscriptionOption(
            title = "1 Month Subscription",
            description = "Start your 7-day free trial then \$7.99 / month.\nSubscription continues until cancelled",
            price = "$7.99",
            isSelected = true,
        )
        SubscriptionOption(
            title = "3 Month Subscription",
            description = "Start your 7-day free trial then \$19.99 / month.\nSubscription continues until cancelled",
            price = "$19.99",
            isSelected = false,
        )
        SubscriptionOption(
            title = "12 Month Subscription",
            description = "Start your 7-day free trial then \$79.99 / month.\nSubscription continues until cancelled",
            price = "$79.99",
            isSelected = false,
        )

    }
}