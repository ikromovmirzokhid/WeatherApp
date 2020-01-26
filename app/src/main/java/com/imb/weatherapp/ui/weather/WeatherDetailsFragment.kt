package com.imb.weatherapp.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.imb.weatherapp.R
import com.imb.weatherapp.di.component.DaggerFragmentComponent
import com.imb.weatherapp.di.component.FragmentComponent
import com.imb.weatherapp.di.module.FragmentModule
import com.imb.weatherapp.models.CurrentWeatherDetails
import kotlinx.android.synthetic.main.current_weather_fragment_view.*
import javax.inject.Inject

class WeatherDetailsFragment : Fragment(), WeatherDetailsContract.View {

    @Inject
    lateinit var presenter: WeatherDetailsPresenter
    lateinit var fragmentComponent: FragmentComponent
    private lateinit var rView: View

    companion object {
        fun create(): WeatherDetailsFragment = WeatherDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rView = inflater.inflate(R.layout.current_weather_fragment_view, container, false)
        presenter.attach(this)
        return rView

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
    }

    private fun injectDependencies() {
        fragmentComponent =
            DaggerFragmentComponent.builder().fragmentModule(FragmentModule()).build()

        fragmentComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.loadData()

    }

    override fun showProgress(show: Boolean) {
        if (show)
            progressBar.visibility = View.VISIBLE
        else {
            progressBar.visibility = View.GONE
            makeOtherViewsVisible()
        }
    }

    private fun makeOtherViewsVisible() {
        placeText.visibility = View.VISIBLE
        lastUpdateText.visibility = View.VISIBLE
        temperatureText.visibility = View.VISIBLE
        humidityText.visibility = View.VISIBLE
        pressureText.visibility = View.VISIBLE
        windText.visibility = View.VISIBLE
        descriptionText.visibility = View.VISIBLE
        icon.visibility = View.VISIBLE
    }


    override fun loadDataSuccess(details: CurrentWeatherDetails) {
        placeText.setText("${details.region}, ${details.country}")
        lastUpdateText.setText("Last Updated: ${details.updatedTime}")
        temperatureText.setText("${details.temperature}°")
        humidityText.setText("Humidity: ${details.humidity} %")
        pressureText.setText("Pressure: ${details.pressure} hPa")
        windText.setText("Wind ${details.windSpeed} km/h")
        descriptionText.setText(details.weatherDesc)
        Glide.with(this).load(details.weatherIcon).into(icon)

    }
}
