from django.shortcuts import get_object_or_404, get_list_or_404
from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view

from rest_framework.decorators import authentication_classes, permission_classes
from rest_framework.permissions import IsAuthenticated
from rest_framework_jwt.authentication import JSONWebTokenAuthentication

from .serializers import GymSerializer, MatchSerializer
from .models import Gym, Match

# Create your views here.

@api_view(['GET', 'POST'])
# JWT 를 활용한 인증을 할 때 JWT 자체를 검증한 인증 여부와 상관 없이 JWT가 유효한지 여부만 파악(토큰이 유효한지 파악)
@authentication_classes([JSONWebTokenAuthentication])
# 인증이 되지 않은 상태로 요청이 오면 "자격 인증 데이터"가 제공되지 않았습니다 와 같은 메세지를 응답함
@permission_classes([IsAuthenticated])
def gym_create(request):
    if request.method == 'GET':
        # gyms = get_list_or_404(Gym)
        serializer = GymSerializer(request.user.gyms, many=True)
        return Response(serializer.data)
    
    elif request.method == 'POST':
        serializer = GymSerializer(data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save(owner=request.user)
            return Response(serializer.data, status=status.HTTP_201_CREATED)

@api_view(['PUT', 'DELETE'])
@authentication_classes([JSONWebTokenAuthentication])
@permission_classes([IsAuthenticated])
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
@authentication_classes([JSONWebTokenAuthentication])
@permission_classes([IsAuthenticated])
def match_create(request):
    if request.method == 'GET':
        matches = get_list_or_404(Match)
        serializer = MatchSerializer(matches, many=True)
        return Response(serializer.data)
    
    elif request.method == 'POST':
        serializer = MatchSerializer(data=request.data)
        if serializer.is_valid(raise_exception=True):
            print(request.user)
            serializer.save(owner=request.user)
            return Response(serializer.data, status=status.HTTP_201_CREATED)

@api_view(['PUT', 'DELETE'])
@authentication_classes([JSONWebTokenAuthentication])
@permission_classes([IsAuthenticated])
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