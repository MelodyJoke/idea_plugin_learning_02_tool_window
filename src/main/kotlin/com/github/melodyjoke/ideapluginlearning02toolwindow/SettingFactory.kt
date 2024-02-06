package com.github.melodyjoke.ideapluginlearning02toolwindow

import com.intellij.openapi.options.SearchableConfigurable
import java.io.File
import java.io.RandomAccessFile
import java.nio.charset.StandardCharsets
import javax.swing.JComponent

class SettingFactory : SearchableConfigurable {

    private val settingUI = SettingUI()

    override fun getId(): String = "test.id"

    override fun getDisplayName(): String = "Test Config"

    override fun createComponent(): JComponent? = settingUI.component

    override fun isModified(): Boolean = true

    override fun apply() {
        val url = settingUI.urlTextField.text

        try {
            val file = RandomAccessFile(File(url), "r")
            file.seek(0)

            val buffer = ByteArray(1 shl 20)
            val size = file.read(buffer)

            val copied = ByteArray(size)
            System.arraycopy(buffer, 0, copied, 0, size)

            val string = String(copied, StandardCharsets.UTF_8)

            READ_UI?.textContent?.text = string
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
