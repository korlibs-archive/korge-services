import com.soywiz.korge.*
import com.soywiz.korge.scene.*
import com.soywiz.korge.ui.*
import com.soywiz.korge.view.*
import com.soywiz.korio.util.i18n.*
import korge.i18n.*

suspend fun main() = Korge {
    sceneContainer().changeTo({ MainMyModuleScene() })
}

class MainMyModuleScene : Scene() {
    override suspend fun SContainer.sceneMain() {
        val languages = listOf(Language.SPANISH, Language.ENGLISH)
        views.language = Language.SPANISH
        uiVerticalStack(adjustSize = false) {
            uiComboBox(items = languages).onSelectionUpdate {
                views.language = it.selectedItem
            }
            text("").textProvider {
                when (it) {
                    Language.SPANISH -> "¡Hola Mundo!"
                    Language.ENGLISH -> "Hello World!"
                    else -> "Unknown"
                }
            }
            text("").textProvider {
                when (it) {
                    Language.SPANISH -> "Esto es una prueba"
                    Language.ENGLISH -> "This is a test"
                    else -> "Unknown"
                }
            }
        }
    }
}