package org.breezyweather.remoteviews.presenters

import android.content.Context
import org.breezyweather.common.extensions.formatMeasure
import org.breezyweather.unit.formatting.UnitWidth
import org.breezyweather.unit.temperature.Temperature
import org.breezyweather.unit.temperature.TemperatureUnit

fun formatWidgetTemperature(
    context: Context,
    temperature: Temperature,
    temperatureUnit: TemperatureUnit,
    showDualTemperature: Boolean,
): String {
    val primary = temperature.formatMeasure(
        context,
        temperatureUnit,
        valueWidth = UnitWidth.NARROW,
        unitWidth = UnitWidth.NARROW
    )
    if (!showDualTemperature) return primary

    val secondaryUnit = if (temperatureUnit == TemperatureUnit.FAHRENHEIT) {
        TemperatureUnit.CELSIUS
    } else {
        TemperatureUnit.FAHRENHEIT
    }
    val secondary = temperature.formatMeasure(
        context,
        secondaryUnit,
        valueWidth = UnitWidth.NARROW,
        unitWidth = UnitWidth.NARROW
    )
    return "$primary ($secondary)"
}
