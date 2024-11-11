package com.example.myapplication

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class PaymentRouteWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // Aquí puedes simular los datos que mostraría el widget
        val paymentStatus = "Pago pendiente"  // Simulación de estado de pago
        val nextRoute = "Av. Ejército -> Centro Histórico"  // Ruta en Arequipa
        val timeEstimate = "15 minutos"  // Tiempo estimado para llegar

        for (appWidgetId in appWidgetIds) {
            // Actualizar el widget con la información de la ruta
            val views = RemoteViews(context.packageName, R.layout.widget_payment_route)

            // Establecer los textos en el widget
            views.setTextViewText(R.id.widget_payment_status, "Estado: $paymentStatus")
            views.setTextViewText(R.id.widget_next_route, "Ruta: $nextRoute")
            views.setTextViewText(R.id.widget_time_estimate, "Tiempo: $timeEstimate")

            // Intent para el botón de pago rápido (puedes modificarlo para que apunte a la actividad principal)
            val paymentIntent = Intent(
                context,
                MainActivity::class.java
            )
            val pendingPaymentIntent = PendingIntent.getActivity(context, 0, paymentIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            views.setOnClickPendingIntent(R.id.widget_payment_button, pendingPaymentIntent)

            // Actualizar el widget en la pantalla de inicio
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}
