package com.example.appparasorteio.View

import com.example.appparasorteio.ViewModel.ItemViewModel
import MainScreen
import TelaListaFilmes
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(viewModel: ItemViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "sorteio") {
        composable("sorteio") {
            MainScreen(
                viewModel = viewModel,
                onIrParaAdicionar = { navController.navigate("adicionar") },
                onIrParaLista = { navController.navigate("lista") }
            )
        }
        composable("adicionar") {
            TelaAdicionarFilme(
                onAdicionar = { viewModel.adicionarItem(it) },
                onVoltar = { navController.popBackStack() }
            )
        }
        composable("lista") {
            TelaListaFilmes(
                viewModel = viewModel,
                onVoltar = { navController.popBackStack() }
            )
        }
    }
}
