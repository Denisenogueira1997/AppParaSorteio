import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appparasorteio.ViewModel.ItemViewModel
import com.example.appparasorteio.ui.theme.Black

@Composable
fun MainScreen(
    viewModel: ItemViewModel,
    onIrParaAdicionar: () -> Unit,
    onIrParaLista: () -> Unit
) {
    val sorteado by viewModel.sorteado.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Gray,
                contentColor = Black,
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                        .padding(start = 80.dp, end = 48.dp)
                    ) {
                        Text("Sorteio de Filmes")
                    }
                }
            )
        },
        backgroundColor = Color.LightGray  // Fundo da área abaixo do TopAppBar
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { viewModel.sortearItem() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Gray,
                    contentColor = Black
                )
            ) {
                Text("Sortear um filme")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onIrParaLista() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Gray,
                    contentColor = Black
                )
            ) {
                Text("Ver lista de filmes adicionados")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = sorteado?.let { "Item sorteado: ${it.nome}" } ?: "Nenhum item sorteado ainda",
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.height(40.dp))

            Surface(
                modifier = Modifier.size(56.dp),
                shape = CircleShape,
                color = Color.Gray
            ) {
                IconButton(
                    onClick = onIrParaAdicionar,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Adicionar novo item",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}







