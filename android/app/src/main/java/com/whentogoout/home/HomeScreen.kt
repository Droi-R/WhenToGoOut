package com.whentogoout.home

// Jetpack Compose 기본 요소
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// ViewModel 관련
import androidx.hilt.navigation.compose.hiltViewModel
import com.droker.domain.model.GithubEntity
import com.whentogoout.study.DemoScreen
import com.whentogoout.study.DemoText


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreenScaffold(
        uiState = UiState.Success,
        homeItems = listOf(
            GithubEntity("Droker", "ididid", "2025", "http"),
            GithubEntity("Droker", "ididid", "2025", "http"),
            GithubEntity("Droker", "ididid", "2025", "http"),
            GithubEntity("Droker", "ididid", "2025", "http"),
        )
    )
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
//    val homeItems by viewModel.homeItems.collectAsState()
//    val uiState by viewModel.uiState.collectAsState()
//
//    viewModel.getUserRepo("Droker")
//
//    Scaffold(
//        topBar = { TopAppBar(title = { Text("Home") }) }
//    ) { padding ->
//        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
//            when (uiState) {
//                is UiState.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//                is UiState.Success -> HomeContent(homeItems)
//                is UiState.Error -> {
//                    val errorMessage = (uiState as UiState.Error).message
//                    Text(text = errorMessage, modifier = Modifier.align(Alignment.Center), color = Color.Red)
//                }
//            }
//        }
//    }
//}


@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val homeItems by viewModel.homeItems.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    viewModel.getUserRepo("Droker")

    // Scaffold 부분을 별도 함수로 분리
    HomeScreenScaffold(
        uiState = uiState,
        homeItems = homeItems
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenScaffold(
    uiState: UiState,
    homeItems: List<GithubEntity>
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Home") }) }
    ) { padding ->
        HomeScreenContent(
            uiState = uiState,
            homeItems = homeItems,
            padding = padding
        )
    }
}


@Composable
fun HomeScreenContent(
    uiState: UiState,
    homeItems: List<GithubEntity>,
    padding: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when (uiState) {
            is UiState.Loading -> LoadingView()
            is UiState.Success -> HomeContent(homeItems)
            is UiState.Error -> ErrorView((uiState as UiState.Error).message)
        }
    }
}

@Composable
fun LoadingView() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun ErrorView(errorMessage: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = errorMessage, modifier = Modifier.align(Alignment.Center), color = Color.Red)
    }
}


@Composable
fun HomeContent(homeItems: List<GithubEntity>) {
    LazyColumn {
        items(homeItems) { item ->
            HomeItemCard(item)
        }
    }
}


@Composable
fun HomeItemCard(item: GithubEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name, style = MaterialTheme.typography.headlineSmall)
            Text(text = item.id, style = MaterialTheme.typography.bodyMedium)
        }
    }
}