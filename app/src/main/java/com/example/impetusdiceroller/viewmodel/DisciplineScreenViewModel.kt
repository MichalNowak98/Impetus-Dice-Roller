import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.impetusdiceroller.model.DisciplineClass
import kotlin.random.Random


class DisciplineScreenViewModel : ViewModel() {
    private var _selectedDiscipline = mutableStateOf(DisciplineClass.A)
    private var _diceValue = mutableIntStateOf(1)
    private var _isTestPassed = mutableStateOf(false)
    private val _verticalPickerLabel = "Discipline level"

    var diceValue = _diceValue
    var selectedDiscipline = _selectedDiscipline
    var isTestPassed = _isTestPassed
    val verticalPickerLabel = _verticalPickerLabel

    fun rollTheDice() {
        val diceRollValue = Random.nextInt(1, 7)
        _diceValue.intValue = diceRollValue
        _isTestPassed.value = diceRollValue >= requiredValueToPass()
    }

    fun updateSelectedDisciplineClass(value: DisciplineClass) {
        _selectedDiscipline.value = value
    }

    private fun requiredValueToPass(): Int {
        return when (_selectedDiscipline.value) {
            DisciplineClass.A -> 3
            DisciplineClass.B -> 4
            DisciplineClass.C -> 5
        }
    }
}
