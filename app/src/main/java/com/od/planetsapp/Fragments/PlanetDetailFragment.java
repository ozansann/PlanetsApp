package com.od.planetsapp.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.od.planetsapp.Helpers.HelperFunctions;
import com.od.planetsapp.Models.PlanetModel;
import com.od.planetsapp.R;
import com.od.planetsapp.databinding.FragmentPlanetDetailBinding;

public class PlanetDetailFragment extends Fragment {
    private FragmentPlanetDetailBinding binding;
    private PlanetModel selectedPlanet;
    private NavHostFragment navHostFragment;
    private NavController navController;
    private Bundle bundle;
    private NavOptions.Builder navBuilder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        selectedPlanet = (PlanetModel) getArguments().getSerializable("selectedPlanet");
        bundle = new Bundle();
        navBuilder =  new NavOptions.Builder();
        Glide.with(getContext())
             .load(selectedPlanet.getImgSrc().get(0).getImg())
             .into(binding.imageViewPlanet);
        binding.textViewPlanetTitle.setText(selectedPlanet.getName().toUpperCase());
        binding.textViewPlanetDesc.setText(selectedPlanet.getDescription());
        setOnClickListeners();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlanetDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void setOnClickListeners(){
        binding.btnVisitDetailsPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperFunctions.showLoadingDialog(getContext());
                goToWebViewFragment(selectedPlanet.getWikiLink());
            }
        });
    }

    private void goToWebViewFragment(String url){
        bundle.putString("url",url);
        navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right);
        navController.navigate(R.id.action_planetDetailFragment_to_viewWebPageFragment,bundle,navBuilder.build());
    }
}