package com.noisyninja.androidlistpoc

import android.content.Context
import android.content.res.Resources
import android.support.test.InstrumentationRegistry
import com.noisyninja.androidlistpoc.layers.AppExecutors
import com.noisyninja.androidlistpoc.layers.RefWatcherModule
import com.noisyninja.androidlistpoc.layers.UtilModule
import com.noisyninja.androidlistpoc.layers.database.DataBaseModule
import com.noisyninja.androidlistpoc.layers.database.viewmodel.MeViewModel
import com.noisyninja.androidlistpoc.layers.database.viewmodel.ViewModelFactory
import com.noisyninja.androidlistpoc.layers.di.NinjaComponent
import com.noisyninja.androidlistpoc.layers.network.NetworkModule
import org.mockito.Mockito

/**
 * Mock test application with mocked dagger dependencies
 * Created by sudiptadutta on 20/05/18.
 */
class TestApplication : NinjaApp() {

    lateinit var viewModelFactory: ViewModelFactory
    lateinit var meViewModel: MeViewModel

    lateinit var refWatcherModule: RefWatcherModule
    lateinit var utilModule: UtilModule
    lateinit var resourcesModule: Resources
    lateinit var networkModule: NetworkModule
    lateinit var appExecutors: AppExecutors
    lateinit var testApplication: TestApplication
    lateinit var appContext: Context
    lateinit var dataBaseModule: DataBaseModule

    override val ninjaComponent: NinjaComponent by lazy {
        initialise()

        DaggerTestComponent.builder()
                .database(dataBaseModule)
                .app(testApplication)
                .appContext(appContext)
                .executor(appExecutors)
                .network(networkModule)
                .resources(resourcesModule)
                .util(utilModule)
                .refWatcher(refWatcherModule)
                .vmf(viewModelFactory)
                .build()
        //.systemModule(SystemModule(this, LeakCanary.install(this)))
        //.repositoryModule(RepositoryModule())
        //.database()
    }

    private fun initialise() {
        mockAll()

        //Mockito.`when`(meViewModel.hello()).thenReturn(1)
        Mockito.`when`(viewModelFactory.create(MeViewModel::class.java)).thenReturn(meViewModel)
    }

    private fun mockAll() {
        refWatcherModule = Mockito.mock(RefWatcherModule::class.java)
        utilModule = Mockito.mock(UtilModule::class.java)
        resourcesModule = Mockito.mock(Resources::class.java)
        networkModule = Mockito.mock(NetworkModule::class.java)
        appExecutors = Mockito.mock(AppExecutors::class.java)
        testApplication = InstrumentationRegistry.getTargetContext().applicationContext as TestApplication
        appContext = InstrumentationRegistry.getTargetContext()
        dataBaseModule = Mockito.mock(DataBaseModule::class.java)
        meViewModel = Mockito.mock(MeViewModel::class.java)
        viewModelFactory = Mockito.mock(ViewModelFactory::class.java)

/*
        meViewModel.dataBaseModule = dataBaseModule
        meViewModel.networkModule = networkModule
        meViewModel.resources = resourcesModule
        meViewModel.utilModule = utilModule*/
    }

}