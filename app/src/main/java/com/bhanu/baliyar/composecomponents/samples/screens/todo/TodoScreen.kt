package com.bhanu.baliyar.composecomponents.samples.screens.todo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay


data class TodoItem(
    val id: Int,
    val title: String,
    val isCompleted: Boolean
)


//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun SwipeableTodoRow(
//    todo: TodoItem,
//    onCheckedChange: (Boolean) -> Unit,
//    onDelete: () -> Unit
//) {
//    val dismissState = rememberDismissState(
//        confirmStateChange = {
//            if (it == DismissValue.DismissedToStart) {
//                onDelete()
//            }
//            true
//        }
//    )
//
//    SwipeToDismiss(
//        state = dismissState,
//        background = {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//
//            )
//        },
//        directions = setOf(DismissDirection.EndToStart),
//        dismissContent = {
//            TodoRow(todo = todo, onCheckedChange = onCheckedChange)
//        }
//    )
//}

@Composable
fun TodoScreen(viewModel: TodoViewModel = viewModel()) {
    val todos = viewModel.todos


    LazyColumn {
        items(
            items = todos,
            key = { it.id }
        ) { todo ->
            var visible by remember { mutableStateOf(true) }
            var shouldDelete by remember { mutableStateOf(false) }

            if (shouldDelete) {
                LaunchedEffect(Unit) {
                    delay(300)
                    viewModel.deleteTodo(todo.id)
                }
            }

            AnimatedVisibility(
                visible = visible,
                exit = fadeOut(animationSpec = tween(300))
            ) {
                TodoRow(
                    todo = todo,
                    onCheckedChange = { isChecked ->
                        viewModel.toggleTodo(todo.id, isChecked)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            visible = false
                            shouldDelete = true
                        }
                )
            }
        }
    }


//    val todos = remember {
//        mutableStateListOf(
//            TodoItem(
//                id = 1,
//                title = "Wash Clothes",
//                isCompleted = false
//            ), TodoItem(id = 2, title = "Walk the Dog", isCompleted = false)
//        )
//    }


//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        items(todos) { item ->
//            TodoRowWithoutVM(todo = item, onCheckedChange = { isChecked ->
//                val index = todos.indexOfFirst { it.id == item.id }
//                if (index != -1) {
//                    todos[index] = todos[index].copy(isCompleted = isChecked)
//                }
//            })
//        }
//    }
}


@Composable
fun TodoRowWithoutVM(
    todo: TodoItem,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val animatedColor by animateColorAsState(
        targetValue = if (todo.isCompleted) Color.Gray else Color.Black,
        label = "TodoTextColor"
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Checkbox(
            checked = todo.isCompleted,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = todo.title,
            style = MaterialTheme.typography.bodyLarge.copy(
                textDecoration = if (todo.isCompleted) TextDecoration.LineThrough else TextDecoration.None,
                color = animatedColor
            )
        )
    }
}

@Composable
fun TodoRow(
    todo: TodoItem,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(vertical = 8.dp)
    ) {
        Checkbox(
            checked = todo.isCompleted,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = todo.title,
            style = MaterialTheme.typography.bodyLarge.copy(
                textDecoration = if (todo.isCompleted) TextDecoration.LineThrough else TextDecoration.None,
                color = if (todo.isCompleted) Color.Gray else Color.Black
            )
        )
    }
}