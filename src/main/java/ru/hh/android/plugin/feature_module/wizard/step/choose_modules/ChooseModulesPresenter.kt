package ru.hh.android.plugin.feature_module.wizard.step.choose_modules

import com.intellij.openapi.components.ProjectComponent
import ru.hh.android.plugin.feature_module.component.main_parameters.MainParametersInteractor
import ru.hh.android.plugin.feature_module.component.module.ModuleInteractor
import ru.hh.android.plugin.feature_module.core.BasePresenter
import ru.hh.android.plugin.feature_module.wizard.step.choose_modules.model.LibraryModuleDisplayableItem
import ru.hh.android.plugin.feature_module.wizard.step.choose_modules.model.converter.LibraryModuleConverter

class ChooseModulesPresenter(
        private val moduleInteractor: ModuleInteractor,
        private val mainParametersInteractor: MainParametersInteractor
) : BasePresenter<ChooseModulesView>(), ProjectComponent {

    override fun onCreate() {
        super.onCreate()

        // TODO - background thread?
        val libraries = moduleInteractor.getLibrariesModules()
        val forceEnabledModulesNames = mainParametersInteractor.getForceEnabledModulesNamesForParameters()

        view.showList(LibraryModuleConverter().convert(libraries, forceEnabledModulesNames))
    }


    fun onLibraryItemSelected(item: LibraryModuleDisplayableItem) {
        // TODO - показать README в секции описания.
    }

    fun onLibraryItemToggleChanged(item: LibraryModuleDisplayableItem) {
        // TODO
    }

}