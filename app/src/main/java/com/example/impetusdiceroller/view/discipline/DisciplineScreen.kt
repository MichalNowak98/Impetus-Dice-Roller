package com.example.impetusdiceroller.view.discipline

import DisciplineScreenViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.impetusdiceroller.model.DisciplineClass
import com.example.impetusdiceroller.view.Dice
import com.example.impetusdiceroller.view.VerticalPicker

@Composable
fun DisciplineScreen(viewModel: DisciplineScreenViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                VerticalPicker<DisciplineClass>(
                    DisciplineClass.entries.toTypedArray(),
                    viewModel.verticalPickerLabel,
                    viewModel.selectedDiscipline.value
                ) { viewModel.updateSelectedDisciplineClass(it) }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                )
                {
                    Dice(viewModel.diceValue.intValue)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                )
                { Text(text = if (viewModel.isTestPassed.value) "The test is passed" else "The test is failed") }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { viewModel.rollTheDice() },
                modifier = Modifier
                    .height(60.dp)
                    .padding(top = 16.dp),
            ) {
                Text(text = "Roll the dice")
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun TwoRowsLayoutPreview() {
    DisciplineScreen(DisciplineScreenViewModel())
}

