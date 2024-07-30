package com.mmartosdev.photofx.materials

import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mmartosdev.photofx.materials.asset01.FragmentShaderContent
import com.mmartosdev.photofx.materials.asset02.LinearGradientContent
import com.mmartosdev.photofx.materials.asset03.StripeContent
import com.mmartosdev.photofx.materials.asset04.ShaderAsUniformContent

enum class AssetType {
    ASSET01,
    ASSET02,
    ASSET03,
    ASSET04,
}

@Composable
fun AssetGallery(
    onAssetSelected: (AssetType) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = spacedBy(16.dp),
        verticalArrangement = spacedBy(16.dp),
        modifier = modifier,
    ) {
        items(AssetType.entries) { assetType ->
            OutlinedCard(
                onClick = { onAssetSelected(assetType) },
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(16f / 9f)
            ) {
                AssetContainer(
                    modifier = Modifier.padding(16.dp)
                ) {
                    when (assetType) {
                        AssetType.ASSET01 -> FragmentShaderContent()
                        AssetType.ASSET02 -> LinearGradientContent()
                        AssetType.ASSET03 -> StripeContent()
                        AssetType.ASSET04 -> ShaderAsUniformContent()
                    }
                }
            }
        }
    }
}