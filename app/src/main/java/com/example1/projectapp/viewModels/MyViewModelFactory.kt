import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example1.projectapp.ItemDetailsActivity
import com.example1.projectapp.viewModels.MedicamentViewModel

class MyViewModelFactory(val application: Application, private val arg1: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MedicamentViewModel::class.java)) {
            return MedicamentViewModel(application, arg1) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}
