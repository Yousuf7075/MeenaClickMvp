package com.example.meenaclickmvp.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meenaclickmvp.R
import com.example.meenaclickmvp.Utils.GridSpacingItemDecoration
import com.example.meenaclickmvp.Utils.ScreenUtils
import com.example.meenaclickmvp.model.CatalogProductsItem
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), HomeContract.View {
    lateinit var presenter: HomePresenter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shimmer.startShimmer()

        recyclerView = view.productRecycler
        presenter = HomePresenter(this)
        presenter.receivedApiData()

    }

    override fun setDataIntoAdapter(list: ArrayList<CatalogProductsItem>) {
        val spaceSize = 13.00
        shimmer.stopShimmer()
        shimmer.visibility =  View.GONE
        recyclerView.visibility = View.VISIBLE

        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.addItemDecoration(GridSpacingItemDecoration(2, ScreenUtils.dp2px(context, spaceSize.toFloat()),true))
        val adapter = HomeAdapter(list, this)
        recyclerView.adapter = adapter
    }

}
