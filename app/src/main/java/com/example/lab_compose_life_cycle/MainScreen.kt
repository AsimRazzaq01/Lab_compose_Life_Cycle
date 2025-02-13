package com.example.lab_compose_life_cycle

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun CreateText(d: String){
    Text(text = d, fontSize = 30.sp)
    SideEffect {
        println("CreateText - SideEffect Executed")
    }
    val unit by rememberSaveable { mutableStateOf(null) }
    LaunchedEffect(unit) {
        println("CreateText - LaunchEffect Executed")
    }
}

@Composable
fun CreateTextField(){
    var text by rememberSaveable { mutableStateOf("") }

    //local Variable to hold count
    var count by rememberSaveable { mutableStateOf(0) }

    TextField(
        value = text,
        onValueChange = {text = it},
        label = { Text("Enter Message") }
    )
    SideEffect {
        println("CreateTextField - SideEffect Executed")
        count++
        println("The count is: $count")
    }

    val unit by rememberSaveable { mutableStateOf(null) }
    LaunchedEffect(unit) {
        println("CreateTextField - LaunchEffect Executed")
    }
}


@Composable
fun MainScreen(modifier: Modifier){
    Column(modifier) {
        Text("Main Screen", fontSize = 30.sp)



        // call functions
        CreateText("Name")
        CreateTextField()

        // Side Effect
        SideEffect {
            println("MainScreen - SideEffect Executed")
        }

        // call functions again
        CreateText("Address")
        CreateTextField()

        // Launch Effect
        val unit by rememberSaveable { mutableStateOf(null) }
        LaunchedEffect(unit) {
            println("CreateTextField - LaunchEffect Executed")
        }






    } // End of Column
}  // End of Main func



