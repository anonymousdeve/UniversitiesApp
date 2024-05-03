package appssquare.projects.HealloCare.core.presentation.adapter

import ali.hrhera.module.base.ui.adapter.BaseViewHolder
import ali.hrhera.module.base.ui.adapter.MultipleViewHolderBaseRecyclerAdapter
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * Base adapter for RecyclerViews with a single view type.
 *
 * @param DTO The type of data object used by the adapter.
 * @param Binding The specific ViewBinding class for the adapter.
 */
abstract class SingleViewHolderBaseRecyclerAdapter<DTO, Binding : ViewBinding> :
    MultipleViewHolderBaseRecyclerAdapter<DTO>() {

    /**
     * Called when RecyclerView needs a new [BaseViewHolder] of the given type to represent an item.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new [BaseViewHolder] that holds a View of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Binding> {
        return getViewHolder(parent, viewType)
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder The view holder that should be updated.
     * @param position The position of the item within the adapter's data set.
     */

    /**
     * Creates a new [BaseViewHolder] for the given view type.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new [BaseViewHolder] that holds a View of the given view type.
     */
    override fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Binding> {
        return BaseViewHolder(createBinding(parent, viewType))
    }

    /**
     * Creates the [Binding] instance for the specified view type.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The [Binding] instance for the specified view type.
     */
    abstract override fun createBinding(parent: ViewGroup, viewType: Int): Binding

    /**
     * Binds the data to the view holder at the specified position.
     *
     * @param binding The view binding instance to bind data to.
     * @param position The position of the item within the adapter's data set.
     */
    protected abstract fun bind(binding: Binding, position: Int)

    override fun bind(holder: BaseViewHolder<ViewBinding>, position: Int) {
        bind(holder.binding as Binding, position)
    }
}
