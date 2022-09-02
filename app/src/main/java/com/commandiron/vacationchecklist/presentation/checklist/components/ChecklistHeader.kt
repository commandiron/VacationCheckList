package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.commandiron.vacationchecklist.presentation.components.CustomCircularIcon
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.Strings.English.CHECKLIST

@Composable
fun ChecklistHeader(
    modifier: Modifier = Modifier,
    text: String,
    drawableId: Int,
    checkCount: Int,
    totalCount: Int,
    isChecklistCompeted: Boolean
) {
    val spacing = LocalSpacing.current
    Row(modifier = modifier) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = spacing.spaceMedium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = CHECKLIST,
                style = MaterialTheme.typography.displayMedium
            )
            Divider(color = LocalContentColor.current.copy(alpha = 0.2f))
        }
        Surface(
            modifier = Modifier
                .weight(1f)
                .height(spacing.bottomNavigationHeight),
            shape = RoundedCornerShape(
                topStart = spacing.spaceLarge,
                bottomStart = spacing.spaceLarge
            ),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.spaceSmall),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomCircularIcon(
                    iconDrawable = drawableId
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(2f),
                        text = text,
                        style = MaterialTheme.typography.bodyLarge,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "${checkCount}/${totalCount}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if(isChecklistCompeted){
                            Color.Green
                        }else LocalContentColor.current.copy(alpha = 0.5f),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}