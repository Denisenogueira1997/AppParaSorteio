
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.ArrowBack
import com.example.appparasorteio.ViewModel.ItemViewModel

@Composable
fun TelaListaFilmes(
    viewModel: ItemViewModel,
    onVoltar: () -> Unit
) {
    val itens = viewModel.items.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Filmes Adicionados") },
                navigationIcon = {
                    IconButton(onClick = onVoltar) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                },
                backgroundColor = Color.Gray
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(16.dp)) {
            if (itens.value.isEmpty()) {
                Text("Nenhum filme adicionado ainda.")
            } else {
                LazyColumn( modifier = Modifier.fillMaxWidth()) {
                    items(itens.value) { item ->
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 2.dp),
                            color = Color.Gray,
                            elevation = 0.dp
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(0.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = item.nome,
                                    style = MaterialTheme.typography.body1,
                                    modifier = Modifier.weight(1f)
                                )
                                IconButton(onClick = { viewModel.removerItem(item) }) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Excluir item"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

