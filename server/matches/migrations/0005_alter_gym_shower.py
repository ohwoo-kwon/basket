# Generated by Django 3.2.4 on 2021-06-22 00:58

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('matches', '0004_alter_gym_parking'),
    ]

    operations = [
        migrations.AlterField(
            model_name='gym',
            name='shower',
            field=models.BooleanField(),
        ),
    ]
