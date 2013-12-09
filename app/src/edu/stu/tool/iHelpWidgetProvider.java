package edu.stu.tool;

import edu.stu.ihelp.client.CameraWrapper;
import edu.stu.ihelp.client.General;
import edu.stu.ihelp.client.IHelpActivity;
import edu.stu.ihelp.client.R;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

public class iHelpWidgetProvider extends AppWidgetProvider {
    @Override
    public void onAppWidgetOptionsChanged (Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        
    }
    
    @Override
    public void onDeleted (Context context, int[] appWidgetIds) {
        
    }
    
    @Override
    public void onDisabled (Context context) {
        
    }
    
    @Override
    public void onEnabled (Context context) {
        
    }
    
    @Override
    public void onReceive (Context context, Intent intent) {
        super.onReceive(context, intent);
    }
    
    @Override
    public void onUpdate (Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;
        
        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // iHelp
            {
                // Create an Intent to launch IHelpActivity
                Intent intent = new Intent(context, IHelpActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
                
                // Get the layout for the App Widget and attach an on-click listener
                // to the button
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ihelp_widget);
                views.setOnClickPendingIntent(R.id.iHelpButton, pendingIntent);
                
                // Tell the AppWidgetManager to perform an update on the current app widget
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }
            
            // Video
            {
                // Create an Intent to launch CameraWrapper
                Intent intent = new Intent(context, CameraWrapper.class);
                Bundle b = new Bundle();
                b.putInt("REQ_CODE", CameraWrapper.REQ_CODE_VIDEO);
                intent.putExtras(b);
                
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
                
                // Get the layout for the App Widget and attach an on-click listener
                // to the button
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ihelp_widget);
                views.setOnClickPendingIntent(R.id.VideoButton, pendingIntent);
                
                // Tell the AppWidgetManager to perform an update on the current app widget
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }
            
            // Camera
            {
                // Create an Intent to launch CameraWrapper
                Intent intent = new Intent(context, CameraWrapper.class);
                Bundle b = new Bundle();
                b.putInt("REQ_CODE", CameraWrapper.REQ_CODE_CAMERA);
                intent.putExtras(b);
                
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                
                // Get the layout for the App Widget and attach an on-click listener
                // to the button
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ihelp_widget);
                views.setOnClickPendingIntent(R.id.CameraButton, pendingIntent);
                
                // Tell the AppWidgetManager to perform an update on the current app widget
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }
            
            // General
            {
                // Create an Intent to launch General
                Intent intent = new Intent(context, General.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
                
                // Get the layout for the App Widget and attach an on-click listener
                // to the button
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ihelp_widget);
                views.setOnClickPendingIntent(R.id.GeneralButton, pendingIntent);
                
                // Tell the AppWidgetManager to perform an update on the current app widget
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }
        }
    }
}
