package com.portfolio.drinkme.ui.home.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.portfolio.drinkme.R
import com.portfolio.drinkme.model.Category
import com.portfolio.drinkme.model.Smooth
import com.portfolio.drinkme.ui.home.adapter.CategoryAdapter
import com.portfolio.drinkme.ui.home.adapter.SmoothAdapter
import com.portfolio.drinkme.utils.constants.ITEM_PLACEHOLDER
import kotlinx.android.synthetic.main.fragment_smoothie.view.*


class SmoothieFragment : Fragment(), SmoothAdapter.SmoothClickListener,
    CategoryAdapter.CategoryClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var viewOfLayout: View
    lateinit var recyclerViewSmoothie: RecyclerView
    lateinit var recyclerViewCategory: RecyclerView
    lateinit var adapterSmoothie: SmoothAdapter
    lateinit var adapterCategory: CategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater.inflate(R.layout.fragment_smoothie, container, false)
        buildSmoothRecycler()
        buildCategoryRecycler()

        val smooth = mutableListOf<Smooth>()
        smooth.add(Smooth(ITEM_PLACEHOLDER))
        adapterSmoothie.setListSmooth(getSmoothies())
        adapterSmoothie.notifyDataSetChanged()


        adapterCategory.setListSmooth(getCategories())
        adapterCategory.notifyDataSetChanged()

        return viewOfLayout
    }

    private fun buildCategoryRecycler() {
        val layoutManagerCategory: LinearLayoutManager =
            GridLayoutManager(activity, 1, GridLayoutManager.HORIZONTAL, false)

        adapterCategory = CategoryAdapter(this)
        recyclerViewCategory = viewOfLayout.recyclerCategory
        recyclerViewCategory.layoutManager = layoutManagerCategory
        recyclerViewCategory.adapter = adapterCategory
    }

    fun buildSmoothRecycler() {
        val layoutManagerSmoothie: LinearLayoutManager =
            GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        adapterSmoothie = SmoothAdapter(this)
        recyclerViewSmoothie = viewOfLayout.recyclerSmooth
        recyclerViewSmoothie.layoutManager = layoutManagerSmoothie
        recyclerViewSmoothie.adapter = adapterSmoothie
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.smoothie_top_bar_menu, menu)
    }

    private fun getCategories(): MutableList<Category> {
        val category = mutableListOf<Category>()
        category.add(Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"))
        category.add(Category("1", "Energy", "ic_category_energy_2", "#ffffff", "#FFB841"))
        category.add(Category("1", "Protein", "ic_category_protein", "#ffffff", "#41A6F9"))
        category.add(Category("1", "Vegan", "ic_category_vegan", "#ffffff", "#FFB841"))
        category.add(Category("1", "Green", "ic_category_green", "#ffffff", "#4cb050"))
        Logger.i(Gson().toJson(category))
        return category
    }

    private fun getSmoothies(): MutableList<Smooth> {
        val smooth = mutableListOf<Smooth>()
        val ingredients = mutableListOf<String>()
        ingredients.add("250 mL de agua")
        ingredients.add("3 cdas. de avena cruda")
        ingredients.add("1 manzana pequeña pelada y partida")
        ingredients.add("1 rebanada delgada de raíz de jengibre")

        val instrcciones = mutableListOf<String>()
        instrcciones.add("1. Mezcla los ingredientes en la licuadora.")
        instrcciones.add("2. Sirve de inmediato.")


        smooth.add(
            Smooth(
                "1",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/Smoothies-recetas2.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Energy", "ic_category_energy_2", "#ffffff", "#FFB841"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "2",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2018/12/smoothie-avena.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("2", "Protein", "ic_category_protein", "#ffffff", "#41A6F9"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "3",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/smoothie-moras-yogurt.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("3", "Vegan", "ic_category_vegan", "#ffffff", "#FFB841"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "4",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/smoothie-antioxidante.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("4", "Green", "ic_category_green", "#ffffff", "#4cb050"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "5",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2018/11/smoothie-de-tofu-fresas-y-platano.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("4", "Green", "ic_category_green", "#ffffff", "#4cb050"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "6",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2018/03/pumpkin-smoothie.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "7",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/Smoothies-recetas2.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "8",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/Smoothies-recetas2.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "9",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/Smoothies-recetas2.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "10",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/Smoothies-recetas2.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "11",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/Smoothies-recetas2.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "12",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/Smoothies-recetas2.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "13",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/Smoothies-recetas2.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )
        smooth.add(
            Smooth(
                "14",
                "1",
                "Vainilla",
                "https://dam.cocinafacil.com.mx/wp-content/uploads/2019/01/Smoothies-recetas2.jpg",
                "Un smoothie de avena es la bebida perfecta para acompañar tu comida y sentirte muy bien. Sigue el paso a paso para prepararla tú misma.",
                Category("1", "Todos", "ic_smoothie", "#ffffff", "#fa718a"),
                "6",
                true,
                ingredients,
                instrcciones,
                ingredients
            )
        )

        Logger.i(Gson().toJson(smooth))

        return smooth
    }

    override fun onSmoothClickListener(smooth: Smooth) {

    }

    override fun onCategoryClickLinstener(category: Category) {

    }


}