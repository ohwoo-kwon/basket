from rest_framework import serializers
from django.contrib.auth import get_user_model

class UserSignupSerializer(serializers.ModelSerializer):
    password = serializers.CharField(write_only=True)

    class Meta:
        model = get_user_model()
        # username 을 email 로 사용
        fields = ('username', 'last_name', 'first_name', 'password', 'is_gym', 'phone_number', 'birth')