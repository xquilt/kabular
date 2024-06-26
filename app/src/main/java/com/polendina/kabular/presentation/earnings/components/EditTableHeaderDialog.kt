package com.polendina.kabular.presentation.earnings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polendina.kabular.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTableHeaderDialog(
    modifier: Modifier = Modifier,
    currentHeader: String,
    onDismissRequest: () -> Unit,
    onHeaderValueChange: (String) -> Unit,
    invalidHeaderTitle: Boolean,
    onAcceptNewHeader: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier
    ) {
        Card {
            Column (
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.padding(top = 15.dp))
                Column {
                    Text(
                        text = stringResource(id = R.string.edit_column_title),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    TextField(
                        value = currentHeader,
                        onValueChange = onHeaderValueChange,
                        isError = invalidHeaderTitle,
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.column_title),
                                style = TextStyle(
                                    color = Color.Gray
                                )
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier .padding(vertical = 35.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    TextButton(onClick = onDismissRequest) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.error
                            )
                        )
                    }
                    Button(
                        onClick = onAcceptNewHeader,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                    ) {
                        Text(
                            text = stringResource(id = R.string.save_close)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun EditTableHeaderDialogPreview() {
    var currentHeader: String by remember { mutableStateOf("") }
    var invalidHeaderTitle: Boolean by remember { mutableStateOf(false) }
    Scaffold {
        EditTableHeaderDialog(
            currentHeader = currentHeader,
            onDismissRequest = { /*TODO*/ },
            onHeaderValueChange = {
                currentHeader = it
            },
            onAcceptNewHeader = {
                if (currentHeader.isEmpty()) {
                    invalidHeaderTitle = true
                } else {
                    invalidHeaderTitle = false
                }
            },
            invalidHeaderTitle = invalidHeaderTitle,
            modifier = Modifier
                .padding(it)
        )
    }
}