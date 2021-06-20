from django.db import models
from django.contrib.auth.models import AbstractUser

# Create your models here.
class User(AbstractUser):
    # username 을 email로 사용
    is_gym = models.BooleanField(default=False)
    phone_number = models.CharField(max_length=15)
    birth = models.CharField(max_length=8)