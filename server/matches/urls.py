from django.urls import path
from . import views

urlpatterns = [
    path('', views.gym_create),
    path('gym/<int:gym_pk>/', views.gym_update),
    path('match/', views.match_create),
    path('match/<int:match_pk>/', views.match_update),
]
