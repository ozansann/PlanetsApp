package com.od.planetsapp.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.od.planetsapp.Adapters.PlanetAdapter;
import com.od.planetsapp.Helpers.HelperFunctions;
import com.od.planetsapp.Helpers.RecyclerTouchListener;
import com.od.planetsapp.Models.PlanetModel;
import com.od.planetsapp.R;
import com.od.planetsapp.ViewModel.PlanetViewModel;
import com.od.planetsapp.databinding.FragmentPlanetListBinding;
import java.util.ArrayList;
import java.util.List;

public class PlanetListFragment extends Fragment {
    private FragmentPlanetListBinding binding;
    private LinearLayoutManager layoutManager;
    private PlanetAdapter adapter;
    private ArrayList<PlanetModel> planetArrayList;
    private List<PlanetModel> planetList;
    private PlanetViewModel planetViewModel;
    private Bundle bundle;
    private NavHostFragment navHostFragment;
    private NavController navController;
    private NavOptions.Builder navBuilder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        planetArrayList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlanetListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents();
        swipeRefresh();
    }

    private void initializeComponents() {
        layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(false);
        adapter = new PlanetAdapter(getContext(), planetArrayList);
        binding.recyclerView.setAdapter(adapter);
        bundle = new Bundle();
        navBuilder =  new NavOptions.Builder();
        binding.recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), binding.recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                goToDetailFragment(planetArrayList.get(position));
            }
        }));
        planetViewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);
        getPlanetList();
    }

    private void goToDetailFragment(PlanetModel selectedPlanet){
        bundle.putSerializable("selectedPlanet",selectedPlanet);
        navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right);
        navController.navigate(R.id.action_planetListFragment_to_planetDetailFragment,bundle,navBuilder.build());
    }

    private void swipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener(() -> {
            binding.swipeRefresh.setRefreshing(false);
            getPlanetList();
        });
    }

    private void getPlanetList() {
        HelperFunctions.showLoadingDialog(getContext());
        planetViewModel.getPlanetListResponseLiveData().observe(getActivity(), planetResponse -> {
            if (planetResponse != null && !planetResponse.isEmpty()) {
                planetList = planetResponse;
                planetArrayList.clear();
                planetArrayList.addAll(planetList);
                adapter.notifyDataSetChanged();
            } else{
                Toast.makeText(getContext(),"hata", Toast.LENGTH_SHORT).show();
            }
            HelperFunctions.hideLoadingDialog();
        });
    }
}