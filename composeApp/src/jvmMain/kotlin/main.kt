import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.mmartosdev.photofx.materials.AssetContainer
import com.mmartosdev.photofx.materials.AssetGallery
import com.mmartosdev.photofx.materials.AssetType
import com.mmartosdev.photofx.materials.asset01.FragmentShaderContent
import com.mmartosdev.photofx.materials.asset02.LinearGradientContent
import com.mmartosdev.photofx.materials.asset03.ShaderAsUniformContent

fun main() = application {
    val windowState = rememberWindowState(width = 800.dp, height = 600.dp)
    Window(onCloseRequest = ::exitApplication, state = windowState) {
        var assetType by remember { mutableStateOf<AssetType?>(null) }
        MaterialTheme {
            Box(modifier = Modifier.background(Color.White)) {
                when (assetType) {
                    AssetType.ASSET01 ->
                        AssetContainer { FragmentShaderContent() }

                    AssetType.ASSET02 ->
                        AssetContainer { LinearGradientContent() }

                    AssetType.ASSET03 ->
                        AssetContainer { ShaderAsUniformContent() }

                    null ->
                        AssetGallery(
                            onAssetSelected = { assetType = it },
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White)
                        )

                }
            }
        }
    }
}
