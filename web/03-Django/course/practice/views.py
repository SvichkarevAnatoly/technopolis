from django.http import HttpResponseRedirect
from django.shortcuts import render, get_object_or_404
from django.urls import reverse

from .models import Student


def get_student_list(request):
    student_list = Student.objects.all()
    context = {'student_list': student_list}
    return render(request, "practice/students.html", context)


def add_student(request):
    if request.method == 'GET':
        return render(request, 'practice/add_student.html')
    else:
        try:
            name = request.POST['name']
            family = request.POST['family']
            student = Student(name=name, family=family)
            student.save()
        except KeyError:
            return render(request, 'practice/add_student.html')
        else:
            return HttpResponseRedirect(reverse('practice:student'))


def edit_student(request, id):
    student = get_object_or_404(Student, pk=id)
    context = {'student': student}
    return render(request, 'practice/edit_student.html', context)


def save_student(request, id):
    student = get_object_or_404(Student, pk=id)
    try:
        student.name = request.POST['name']
        student.family = request.POST['family']
        student.save()
    except KeyError:
        context = {'student': student}
        return render(request, 'practice/edit_student.html', context)
    else:
        return HttpResponseRedirect(reverse('practice:student'))


def delete_student(request, id):
    student = get_object_or_404(Student, pk=id)
    student.delete()
    return HttpResponseRedirect(reverse('practice:student'))
