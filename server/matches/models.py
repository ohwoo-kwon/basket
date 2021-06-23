from django.db import models
from django.conf import settings

# Create your models here.

class Gym(models.Model):
    address = models.CharField(max_length=70)
    court_length = models.IntegerField()
    court_width = models.IntegerField()
    parking = models.BooleanField()
    shower = models.BooleanField()
    normal_size = models.BooleanField()
    owner = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE, related_name='gyms')

class Match(models.Model):
    gym = models.ForeignKey(Gym, on_delete=models.CASCADE)
    date = models.DateField()
    start_time = models.CharField(max_length=5)
    finish_time = models.CharField(max_length=5)
    min_people = models.IntegerField()
    max_people = models.IntegerField()
    owner = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE, related_name='matches')