package com.example.appparasorteio.View.components


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.appparasorteio.R
import com.example.appparasorteio.ui.theme.Blue80

@Composable
fun BotaoTelaInicial(onClick: () -> Unit) {
    Button(onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue80,
            contentColor = Color.White
        )
    ){
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.add),
            contentDescription = "",
            modifier = Modifier.size(20.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "{button text}", color = Color.White)
    }
}
