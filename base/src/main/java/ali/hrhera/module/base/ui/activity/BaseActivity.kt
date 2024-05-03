package ali.hrhera.module.base.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<DataBinding : ViewDataBinding> : AppCompatActivity() {
    /** The data binding instance associated with the activity. */
    lateinit var binding: DataBinding

    /**
     * Initializes the data binding for the activity.
     *
     * This method is responsible for inflating the data binding layout and providing
     * the initialized data binding object.
     *
     * @return An instance of the initialized data binding class.
     */
    abstract fun intBinding(): DataBinding


    /**
     * Invoked after the view setup in onViewCreated().
     *
     * Subclasses should override this method to perform additional setup logic specific to the activity.
     *
     * Note: It is recommended to perform UI-related setup in this method as the view hierarchy is guaranteed
     *       to be initialized by the time this method is called.
     */
    abstract fun afterViewSetUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = intBinding()
        setContentView(binding.root)
        afterViewSetUp()
    }
}