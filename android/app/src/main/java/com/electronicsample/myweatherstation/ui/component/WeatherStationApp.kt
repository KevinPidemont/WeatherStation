package com.electronicsample.myweatherstation.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.electronicsample.myweatherstation.R
import com.electronicsample.myweatherstation.ui.page.home.HomePage

@Composable
fun WeatherStationApp() {
    var index by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = index == 0,
                    onClick = {
                        index = 0
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.home))
                    }
                )

                NavigationBarItem(
                    selected = index == 1,
                    onClick = {
                        index = 1
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_settings_remote),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.communication))
                    }
                )

                NavigationBarItem(
                    selected = index == 2,
                    onClick = {
                        index = 2
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_browse_activity),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.logs))
                    }
                )
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            HomePage()
        }
    }
}

@Preview
@Composable
private fun WeatherStationAppPreview() {
    WeatherStationApp()
}