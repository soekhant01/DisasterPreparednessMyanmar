package com.example.disaster.presentation.navigation

sealed class ReportRoute(val route: String) {
    object List : ReportRoute("report/list")
    object Map : ReportRoute("report/map/{latitude}/{longitude}") {
        fun createRoute(latitude: Double, longitude: Double) =
            "report/map/$latitude/$longitude"
    }
}