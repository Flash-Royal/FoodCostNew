package com.example.foodcost.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodcost.db.entity.Good
import com.example.foodcost.vm.MainVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.insertGood(Good(0, "123", 21))
        vm.insertGood(Good(0, "124", 22))
        vm.insertGood(Good(0, "125", 23))
        vm.insertGood(Good(0, "126", 24))
        setContent {
            GoodScreen(vm)
        }
    }
}

@Composable
fun GoodScreen(
    vm: MainVM = viewModel(),
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        GoodList(goods = vm.goods.observeAsState(
            initial = listOf()),
            onDeleteGood = { good -> vm.deleteGood(good) },
            modifier = modifier)
    }
}

@Composable
fun GoodList(
    goods: State<List<Good>>,
    onDeleteGood: (Good) -> Unit,
    modifier: Modifier
) {
    LazyColumn(modifier = modifier) {
        items(
            goods.value,
            key = { good -> good.id }
        ) { good ->
            GoodListItem(
                good.name,
                onDelete = { onDeleteGood(good) },
                modifier
            )
        }
    }
}

@Composable
fun GoodListItem(
    goodName: String,
    onDelete: () -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = goodName
        )
        IconButton(onClick = onDelete) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

