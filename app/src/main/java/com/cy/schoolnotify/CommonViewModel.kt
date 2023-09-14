package com.cy.schoolnotify

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cy.schoolnotify.screens.onboarding.OnboardingModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor() : ViewModel() {
    data class CommonUIState(
        val commonDialogStateWithSingleOption: CommonEnumForDialogWithSingleOption = CommonEnumForDialogWithSingleOption.Dismiss,
        val showHideState: ShowOrHideStateOfDialog = ShowOrHideStateOfDialog.Hide,
        val OnboardingScreenList: List<OnboardingModel> = emptyList()
    )

    private val _uiStateCommon = MutableStateFlow(CommonUIState())
    val uiStateCommon: StateFlow<CommonUIState> = _uiStateCommon

    init {
        getOnBoardingData()
    }

    private fun getOnBoardingData() {
        viewModelScope.launch {
            _uiStateCommon.update {
                it.copy(
                    OnboardingScreenList = getOnboardingList()
                )
            }
        }
    }

    fun EventCommon(commonEvent: CommonEvent) {
        when (commonEvent) {
            is CommonEvent.ShowedOrHideDialog -> {
                _uiStateCommon.update {
                    it.copy(
                        showHideState = commonEvent.showHide
                    )
                }
            }

            is CommonEvent.DialogWithSingleOption -> {
                _uiStateCommon.update {
                    it.copy(
                        commonDialogStateWithSingleOption = commonEvent.okClicked
                    )
                }
            }


            else -> Unit

        }
    }


    companion object {
        fun getOnboardingList() = listOf(
            OnboardingModel(
                R.drawable.onboarding1, "What is Lorem Ipsum?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
            ),
            OnboardingModel(
                R.drawable.onboarding2,
                "Checkout Us",
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
            ),
            OnboardingModel(
                R.drawable.onboarding3,
                "Our Team",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
            )
        )
    }
}