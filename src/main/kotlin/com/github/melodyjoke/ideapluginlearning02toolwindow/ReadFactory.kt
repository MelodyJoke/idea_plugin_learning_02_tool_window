package com.github.melodyjoke.ideapluginlearning02toolwindow

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class ReadFactory : ToolWindowFactory {

    private val readUI = ReadUI()

    override fun createToolWindowContent(project: Project, window: ToolWindow) {
        val contentFactory = ContentFactory.getInstance()

        val content = contentFactory.createContent(readUI.component, "", false)

        window.contentManager.addContent(content)

        READ_UI = readUI
    }
}
