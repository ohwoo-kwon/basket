from django.shortcuts import get_object_or_404, get_list_or_404
from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view

from .serializers import GymSerializer, MatchSerializer
from .models import Gym, Match

from django.shortcuts import render

# Create your views here.

@api_view(['GET', 'POST'])
def gym_create(request):
    if request.method == 'GET':
        gyms = get_list_or_404(Gym)
        serializer = GymSerializer(gyms, many=True)
        return Response(serializer.data)
    
    elif request.method == 'POST':
        serializer = GymSerializer(data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)

@api_view(['PUT', 'DELETE'])
def gym_update(request, gym_pk):
    gym = get_object_or_404(Gym, pk=gym_pk)

    if request.method == 'PUT':
        serializer = GymSerializer(gym, data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data)
    
    elif request.method == 'DELETE':
        gym.delete()
        return Response({ 'id': gym_pk })

@api_view(['GET', 'POST'])
def match_create(request):
    if request.method == 'GET':
        matches = get_list_or_404(Match)
        serializer = MatchSerializer(matches, many=True)
        return Response(serializer.data)
    
    elif request.method == 'POST':
        serializer = MatchSerializer(data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)

@api_view(['PUT', 'DELETE'])
def match_update(request, match_pk):
    match = get_object_or_404(Match, pk=match_pk)

    if request.method == 'PUT':
        serializer = MatchSerializer(match, data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response(serializer.data)
        
    elif request.method == 'DELETE':
        match.delete()
        return Response({ 'id': match_pk })