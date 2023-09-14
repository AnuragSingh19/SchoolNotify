package com.cy.schoolnotify

sealed class CommonEvent {
    data class DialogWithSingleOption(val okClicked: CommonEnumForDialogWithSingleOption) :
        CommonEvent()

    data class ShowedOrHideDialog(val showHide: ShowOrHideStateOfDialog) : CommonEvent()
}