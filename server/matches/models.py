from django.db import models

# Create your models here.

class gym(models.Model):
    address = models.CharField(max_length=70)
    court_length = models.IntegerField()
    court_width = models.IntegerField()
    parking = models.IntegerField()
    shower = models.IntegerField()
    normal_size = models.BooleanField()