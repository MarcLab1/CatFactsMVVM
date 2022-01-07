package com.catfactscomposemvvm.ui.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Catfact(vm: CatfactViewModel)
{
    Column()
    {

        Row(modifier = Modifier
            .padding(start=5.dp, end=5.dp)
            .fillMaxWidth()
            .fillMaxHeight(.5f), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically)
        {
            Text(vm.catfact.value.toString())
        }

        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically)
        {

            Button(onClick = { vm.populateCatfact() }) {
                Text("Get another cat fact")
            }
        }
    }
}
