from rest_framework import serializers
from .models import Gym, Match

class GymSerializer(serializers.ModelSerializer):

    class Meta:
        model = Gym
        fields = '__all__'

class MatchSerializer(serializers.ModelSerializer):

    class Meta:
        model = Match
        fields = '__all__'