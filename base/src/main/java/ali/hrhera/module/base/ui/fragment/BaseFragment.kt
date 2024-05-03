package ali.hrhera.module.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseFragment<DataBinding : ViewDataBinding> : Fragment() {
    /** The data binding instance associated with the fragment. */
    lateinit var binding: DataBinding

    /**
     * Initializes the data binding for the fragment.
     *
     * This method is responsible for inflating the data binding layout and providing
     * the initialized data binding object.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views.
     * @param container If non-null, this is the parent view that the fragment's UI
     * will be attached to.
     *
     * @return An instance of the initialized data binding class.
     */
    abstract fun intBinding(inflater: LayoutInflater, container: ViewGroup?): DataBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = intBinding(inflater, container)
        binding.executePendingBindings()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterViewSetUp()
    }

    /**
     * Invoked after the view setup in onViewCreated().
     *
     * Subclasses should override this method to perform additional setup logic specific to the fragment.
     *
     * Note: It is recommended to perform UI-related setup in this method as the view hierarchy is guaranteed
     *       to be initialized by the time this method is called.
     */
    abstract fun afterViewSetUp()

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}