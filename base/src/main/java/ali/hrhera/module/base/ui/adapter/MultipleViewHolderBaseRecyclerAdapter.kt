package ali.hrhera.module.base.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Abstract base class for RecyclerView adapters.
 *
 * This class provides a basic structure for creating RecyclerView adapters.
 * It handles the creation of ViewHolders and binding data to them.
 *
 * @param DTO The type of data objects to be displayed in the RecyclerView.
 */
abstract class MultipleViewHolderBaseRecyclerAdapter<DTO> : RecyclerView.Adapter<BaseViewHolder<ViewBinding>>() {

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewBinding> {
        return getViewHolder(parent, viewType)
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding>, position: Int) {
        bind(holder, position)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in the data set.
     */
    override fun getItemCount(): Int {
        return currentData.size
    }

    /**
     * Retrieves the ViewHolder for the given view type.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    open fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewBinding> {
        return BaseViewHolder(createBinding(parent, viewType))
    }

    /**
     * Creates the ViewBinding object for the item view.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The type of the new View.
     * @return The ViewBinding object for the item view.
     */
    abstract fun createBinding(parent: ViewGroup, viewType: Int): ViewBinding

    /**
     * Binds data to the ViewHolder at the specified position.
     *
     * @param holder The ViewHolder to bind data to.
     * @param position The position of the item within the adapter's data set.
     */
    protected abstract fun bind(holder: BaseViewHolder<ViewBinding>, position: Int)

    /**
     * The list of current data objects in the adapter.
     */
    val currentData: MutableList<DTO> = mutableListOf()

    /**
     * Submits a new list of data to the adapter.
     *
     * @param list The new list of data objects to be displayed.
     */
    fun submitData(list: List<DTO>?) {
        if (list.isNullOrEmpty()) {
            if (currentData.isNotEmpty()) {
                notifyItemRangeRemoved(0, currentData.size)
                currentData.clear()
            }
            return
        }
        notifyItemRangeRemoved(0, currentData.size)
        currentData.clear()
        currentData.addAll(list)
        notifyItemRangeInserted(0, currentData.size)
    }

    /**
     * Appends new data to the existing list of data.
     *
     * @param list The list of data objects to append.
     */
    fun append(list: List<DTO>) {
        val size = currentData.size
        currentData.addAll(list)
        notifyItemRangeInserted(size, size + list.size)
    }
    fun append(item: DTO) {
        val size = currentData.size
        currentData.add(item)
        notifyItemRangeInserted(size, size + 1)
    }
}
