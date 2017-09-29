package ytstudios.wall.plus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Yugansh Tyagi on 10-09-2017.
 */

public class Categories_Fragment extends Fragment {

    RecyclerView categories_rv;
    ArrayList<Categories_Model_Class> categories;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.categories_fragment, null);

        categories_rv = view.findViewById(R.id.categories_rv);
        categories_rv.setHasFixedSize(true);

        categories_rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        categories_rv.addItemDecoration(new RecyclerItemDecoration(2));

        initializeCategories();
        initializeAdapter();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu,menu);
        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void initializeCategories() {
        categories = new ArrayList<>();
        categories.add(new Categories_Model_Class("Abstract", R.drawable.abstractimg));
        categories.add(new Categories_Model_Class("Amoled", R.drawable.amoled));
        categories.add(new Categories_Model_Class("Animal", R.drawable.animal));
        categories.add(new Categories_Model_Class("Anime", R.drawable.anime));
        categories.add(new Categories_Model_Class("Cityscape", R.drawable.city));
        categories.add(new Categories_Model_Class("Minimal", R.drawable.minimal));
        categories.add(new Categories_Model_Class("Nature", R.drawable.nature));
        categories.add(new Categories_Model_Class("Vehicles", R.drawable.cars));

    }

    private void initializeAdapter() {
        Categories_Adapter categories_adapter = new Categories_Adapter(getContext(), categories);
        categories_rv.setAdapter(categories_adapter);
    }
}
