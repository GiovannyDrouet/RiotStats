package com.giovannydrouet.riotstats.presentation.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Child of Application() that executes before MainActivity, and make Hilt work with the annotiation
@HiltAndroidApp
class RiotStatsApplication: Application()