package com.giovannydrouet.riotstats.presentation.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Child of Application() to run hilt
@HiltAndroidApp
class RiotStatsApplication: Application()