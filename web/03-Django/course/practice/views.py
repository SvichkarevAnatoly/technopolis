from django.shortcuts import render

from .models import Student


def students(request):
    student_list = Student.objects.all()
    context = {'student_list': student_list}

    return render(request, "practice/index.html", context)
